interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
}

class CityBlockConservation extends RainySeasonConservation {
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length <= 2) {
            return 0;
        } else {
            int highestValue = 0;
            int startIndex = 0;

            int endIndex = 0;
            int secondHighestValue = 0;

            for (int i = 0; i < blockHeights.length; i++) {
                if (blockHeights[i] > highestValue) {
                    secondHighestValue = highestValue;
                    highestValue = blockHeights[i];
                    endIndex = startIndex;
                    startIndex = i;
                } else if (blockHeights[i] > +secondHighestValue) {
                    secondHighestValue = blockHeights[i];
                    endIndex = i;
                }
            }
            System.out.println(highestValue + " " + secondHighestValue);
            System.out.println(endIndex + " " + startIndex);

            // System.out.println(blockHeights.length / 2);
            // for (int i = blockHeights.length / 2; i < blockHeights.length; i++) {
            // if (blockHeights[i] > highestValueRight) {
            // highestValueRight = blockHeights[i];
            // rightIndex = i;
            // }
            // }

            //int highestVal = highestValue > secondHighestValue ? secondHighestValue : highestValue;
            int tappedWater = 0;
            if (startIndex < endIndex) {
                int temp = endIndex;
                endIndex = startIndex;
                startIndex = temp;
            }
            System.out.println(endIndex + " " + startIndex);
            for (int i = endIndex + 1; i < startIndex; i++) {
                tappedWater += secondHighestValue - blockHeights[i];
                System.out.println(secondHighestValue - blockHeights[i]);

            }
            return tappedWater;
        }
    }
}

public class waterConservation {
    public static void main(String[] args) {
        CityBlockConservation c = new CityBlockConservation();
        int[] blockHeights = { 0, 0, 0, 2, 0, 3 };
        int trappedWater = c.calculateTrappedWater(blockHeights);
        System.out.println("Trapped Water: " + trappedWater);
    }
}
