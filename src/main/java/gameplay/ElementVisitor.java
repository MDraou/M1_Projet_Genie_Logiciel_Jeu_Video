package gameplay;

public interface ElementVisitor {
    void visit(Wall wall);
    void visit(Ball ball);
    void visit(Paddle paddle);
    void visit(Score score);
}
