package com.github.btrekkie.connectivity.test;

import com.github.btrekkie.connectivity.Augmentation;

/**
 * Used for testing root augmentation splitting
 */
class ComponentTotalValue {

    public static final Augmentation AUGMENTATION = new Augmentation() {

        @Override
        public Object combine(Object value1, Object value2) {
            return new ComponentTotalValue(((ComponentTotalValue) value1).value + ((ComponentTotalValue) value2).value);
        }

        @Override
        public Object[] split(Object originalAugmentation, int leftSize, int rightSize, int leftOriginalSize) {
            ComponentTotalValue value1 = ((ComponentTotalValue) originalAugmentation);
            double leftPercentageOfOriginal = (double) leftSize / leftOriginalSize;
            double rightPercentageOfOriginal = (double) rightSize / leftOriginalSize;

            double weightedLeft = leftPercentageOfOriginal * value1.value;
            double weightedRight = rightPercentageOfOriginal * value1.value;

            return new Object[] {new ComponentTotalValue((int) weightedLeft), new ComponentTotalValue((int) weightedRight)};
        }
    };

    public final int value;

    public ComponentTotalValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComponentTotalValue)) {
            return false;
        }
        ComponentTotalValue totalValue = (ComponentTotalValue) obj;
        return value == totalValue.value;
    }
}
