package gameplay;

public interface IElementVisitor {
    void visit(Wall wall);
    void visit(Ball ball);
    void visit(Paddle paddle);
    void visit(Score score);
}
