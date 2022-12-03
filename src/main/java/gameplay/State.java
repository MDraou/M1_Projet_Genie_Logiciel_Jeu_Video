package gameplay;

public interface State {

    void ZPressedAction();
    void SPressedAction();
    void UpPressedAction();
    void DownPressedAction();
    void ZReleasedAction();
    void SReleasedAction();
    void UpReleasedAction();
    void DownReleasedAction();
}
