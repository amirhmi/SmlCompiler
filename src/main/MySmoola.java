import ast.VisitorImpl;
import ast.node.Program;
import main.ast.VisitorSecondPass;
import ast.Visitor;
import main.ast.VisitorByteCode;
import ast.VisitorImpl;
import org.antlr.v4.runtime.*;
import java.io.IOException;

public class MySmoola {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        SmoolaLexer lexer = new SmoolaLexer(reader);   // SmoolaLexer in your project
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SmoolaParser parser = new SmoolaParser(tokens);   // SmoolaParser in your project
        Program p = parser.program().p; // program is the name of the start rule

        VisitorImpl v = new VisitorImpl();
        p.accept(v);

        if (v.getHasError())
            return;

        VisitorSecondPass vsp = new VisitorSecondPass(p);
        p.accept(vsp);
        if (vsp.showErrorMessages())
            return;

        VisitorByteCode vbc = new VisitorByteCode();
        p.accept(vbc);
    }
}