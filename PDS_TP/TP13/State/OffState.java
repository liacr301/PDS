public class OffState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new LowSpeedState());
    }

    @Override
    public String getState() {
        return "Off";
    }
}