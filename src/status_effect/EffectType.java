package status_effect;

public enum EffectType {

    MOVIMENTEFFECT(MovimentEffect.class),
    POWEREFFECT(PowerEffect.class),
    ANTIDOTEEFFECT(AntidoteEffect.class),
    NULLEFFECT(NullEffect.class),
    WHORMYEFFECT(NullEffect.class),
    EFFECTLIST(EffectList.class);

    private Class<?> type;

    EffectType(Class<?> effectType) {
        this.type=effectType;
    }

    public Class<?> GetType() {
        return this.type;
    }
    public boolean isInstance(Object obj) {
        return type.isInstance(obj);
    }

}
