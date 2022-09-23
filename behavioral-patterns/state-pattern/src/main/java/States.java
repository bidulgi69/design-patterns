interface State {

    Color[] transition(Context context);
}

class RedLight implements State {

    @Override
    public Color[] transition(Context context) {
        context.setState(new YellowLight());
        //  red to yellow
        Traffic.cars.forEach(Movable::ready);
        Traffic.pedestrians.forEach(Movable::ready);
        return new Color[]{ Color.RED, Color.YELLOW };
    }
}

class GreenLight implements State {

    @Override
    public Color[] transition(Context context) {
        context.setState(new RedLight());
        //  green to red
        Traffic.cars.forEach(Movable::move);
        Traffic.pedestrians.forEach(Movable::stop);
        return new Color[]{ Color.GREEN, Color.RED };
    }
}

class YellowLight implements State {

    @Override
    public Color[] transition(Context context) {
        context.setState(new GreenLight());
        //  yellow to green
        Traffic.cars.forEach(Movable::stop);
        Traffic.pedestrians.forEach(Movable::move);
        return new Color[]{ Color.YELLOW, Color.GREEN };
    }
}

enum Color {
    RED,
    GREEN,
    YELLOW;
}