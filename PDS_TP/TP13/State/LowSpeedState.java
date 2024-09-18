public class LowSpeedState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new MediumSpeedState());
    }

    @Override
    public String getState() {
        return "Low Speed";
    }
}