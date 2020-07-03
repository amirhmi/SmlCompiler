package symbolTable;

import java.util.*;
import ast.node.declaration.VarDeclaration;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import symbolTable.SymbolTableItem;
import symbolTable.SymbolTableClassItem;
import symbolTable.SymbolTableMethodItem;
import symbolTable.SymbolTableVariableItem;
import ast.node.declaration.*;

public class SymbolTable {

	SymbolTable pre;
	HashMap<String, SymbolTableItem> items;

	// Static members region

	public static SymbolTable top;
	
	private static Stack<SymbolTable> stack = new Stack<SymbolTable>();

	public static ArrayList<ClassDeclaration> orphan_classes = new ArrayList<ClassDeclaration>();

	// Use it in pass 1 scope start
	public static void push(SymbolTable symbolTable) {
		if(top != null)
			stack.push(top);
		top = symbolTable;
	}

	// Use it in pass1 scope end
	public static void pop() {
		top = stack.pop();
	}

	// End of static members region

	public SymbolTable() {
		this(null);
	}

	public SymbolTable(SymbolTable pre) {
		this.pre = pre;
		this.items = new HashMap<String, SymbolTableItem>();
	}

	public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new ItemAlreadyExistsException();
		items.put(item.getKey(), item);
	}

	public void put(SymbolTableClassItem item) throws ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new ItemAlreadyExistsException();
		items.put(item.getKey(), item);
		ClassDeclaration me = item.getClassDeclaration();
		// find this class parents and set parent of this class
		if (me.getParentName() != null) {
			String par = item.getClassDeclaration().getParentName().getName();
			String par_key = new SymbolTableClassItem(par, null).getKey();
			SymbolTableClassItem par_item = null;
			if (items.containsKey(new SymbolTableClassItem(par, null).getKey()))
				par_item = (SymbolTableClassItem)items.get(par_key);
			if (par_item != null) {
				me.setParentClassDeclaration(par_item.getClassDeclaration());
				par_item.getClassDeclaration().addChildClassDeclaration(me);
			}
			else {
				me.setParentClassDeclaration(null);
				orphan_classes.add(me);
			}
		}
		else
			me.setParentClassDeclaration(null);
		// find this class childs and set parent of childs
		for(int i = 0; i < orphan_classes.size(); i++) {
			ClassDeclaration child = orphan_classes.get(i);
			if (Objects.equals(child.getParentName().getName(), me.getName().getName())) {
				child.setParentClassDeclaration(me);
				me.addChildClassDeclaration(child);
				orphan_classes.remove(child);
			}
		}
	}

	public void put(SymbolTableMethodItem item) throws  ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new ItemAlreadyExistsException();
		ClassDeclaration me = item.getMethodDeclaration().getClassDeclaration();
		ClassDeclaration par = me.getParentClassDeclaration();
		while (par != null) {
			if (par.getSymbolTable().items.containsKey(item.getKey()))
				throw new ItemAlreadyExistsException();
			par = par.getParentClassDeclaration();
		}
		for (int i = 0; i < me.getChildClassDeclarations().size(); i++)
			if (me.getChildClassDeclarations().get(i).getSymbolTable().items.containsKey(item.getKey()))
				throw new ItemAlreadyExistsException();
		items.put(item.getKey(), item);
	}

	public void put(SymbolTableVariableItem item) throws symbolTable.ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new symbolTable.ItemAlreadyExistsException();
		if (!item.getVariableDeclaration().getIsClassProperty())
		{
			items.put(item.getKey(), item);
			return;
		}
		ClassDeclaration me = item.getVariableDeclaration().getClassDeclaration();
		ClassDeclaration par = me.getParentClassDeclaration();
		while (par != null) {
			if (par.getSymbolTable().items.containsKey(item.getKey()))
				throw new symbolTable.ItemAlreadyExistsException();
			par = par.getParentClassDeclaration();
		}
		for (int i = 0; i < me.getChildClassDeclarations().size(); i++)
			if (me.getChildClassDeclarations().get(i).getSymbolTable().items.containsKey(item.getKey()))
				throw new symbolTable.ItemAlreadyExistsException();
		items.put(item.getKey(), item);
	}

	public SymbolTableItem getInCurrentScope(String key) {
		return items.get(key);
	}

	public SymbolTableItem get(String key) throws ItemNotFoundException {
		SymbolTableItem value = items.get(key);
		if(value == null && pre != null)
			return pre.get(key);
		else if(value == null)
			throw new ItemNotFoundException();
		else
			return value;
	}


	public boolean find(SymbolTableItem item) {
		if(items.containsKey(item.getKey()))
			return true;
		return false;
	}

	public ClassDeclaration findClassDec(SymbolTableClassItem item) {
		if (items.containsKey(item.getKey()))
			return ((SymbolTableClassItem)items.get(item.getKey())).getClassDeclaration();
		return null;
	}

	public VarDeclaration findVarDec(SymbolTableVariableItem item) {
		if (items.containsKey(item.getKey())) {
			return ((SymbolTableVariableItem) items.get(item.getKey())).getVariableDeclaration();
		}
		return null;
	}

	public static MethodDeclaration findMethodDec(SymbolTableMethodItem item, ClassDeclaration classDeclaration) {
		ClassDeclaration me = classDeclaration;
		while (me != null) {
			if (me.getSymbolTable().items.containsKey(item.getKey()))
				return ((SymbolTableMethodItem)me.getSymbolTable().items.get(item.getKey())).getMethodDeclaration();
			me = me.getParentClassDeclaration();
		}
		return null;
	}

	public int findVarId(ast.node.expression.Identifier varname) {
		SymbolTableVariableItem item = new SymbolTableVariableItem(varname.getName(), null, null);
		if (items.containsKey(item.getKey()))
			return ((SymbolTableVariableItem) items.get(item.getKey())).getIndex();
		return -1;
	}

	public SymbolTable getPreSymbolTable() {
		return pre;
	}
}