public interface State {
    void pull(CeilingFan fan);
    String getState();
}
