public class HighSpeedState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new OffState());
    }

    @Override
    public String getState() {
        return "High Speed";
    }
}