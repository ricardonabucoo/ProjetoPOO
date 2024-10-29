package status_effect;

public enum EffectType {

    MOVIMENTEFFECT(MovimentEffect.class),
    POWEREFFECT(PowerEffect.class),
    ANTIDOTEEFFECT(AntidoteEffect.class),
    NULLEFFECT(NullEffect.class),
    WHORMYEFFECT(NullEffect.class),
    EFFECTLIST(EffectList.class);

    private final Class<?> type;

    EffectType(Class<?> typeEffect) {
        this.type=typeEffect;
    }

    public Class<?> GetType() {

        return this.type;

    }

    public boolean isInstance(Object obj) {
        return type.isInstance(obj);
    }


}
