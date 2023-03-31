package eu.rvlander.swarm_melee.core.model;

public class PositionLookup {
    private final Fighter fighter;
    public final Type type;

    public static PositionLookup Fighter(Fighter fighter) {
        return new PositionLookup(Type.FIGHTER, fighter);
    }

    public static PositionLookup Forbidden() {
        return new PositionLookup(Type.FORBIDDEN);
    }

    public static PositionLookup Empty() {
        return new PositionLookup(Type.FIGHTER);
    }

    private PositionLookup (Type type) {
        this.type = type;
        this.fighter = null;
        assert isValid();
    }

    private PositionLookup (Type type, Fighter fighter) {
        this.type = type;
        this.fighter = fighter;
        assert isValid();
    }

    private boolean isValid() {
        return fighter != null || type != Type.FIGHTER;
    }

    public enum Type {
        EMPTY,
        FORBIDDEN,
        FIGHTER,
    }
}
