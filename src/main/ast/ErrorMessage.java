package main.ast;

public class ErrorMessage implements Comparable<ErrorMessage>{
    private String message;
    private int line;
    public ErrorMessage(int line, String message) {
        this.message = message;
        this.line = line;
    }

    public void showError()
    {
        System.out.println("Line:" + line + ":" + message);
    }

    @Override
    public int compareTo(ErrorMessage o) {
        return (this.line - o.line);
    }
}
