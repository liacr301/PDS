public class CeilingFan {
    private State currentState;

    public CeilingFan() {
        currentState = new OffState();
    }

    public void setState(State state) {
        currentState = state;
    }

    public void pull() {
        currentState.pull(this);
    }

    public String getState() {
        return currentState.getState();
    }
}
