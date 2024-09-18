public class MediumSpeedState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new HighSpeedState());
    }

    @Override
    public String getState() {
        return "Medium Speed";
    }
}