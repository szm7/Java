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
            int highestValueLeft = blockHeights[0];
            int leftIndex = 0;

            int highestValueRight = blockHeights[0];
            int rightIndex = 0;

            for (int i = 0; i < blockHeights.length / 2; i++) {
                if (blockHeights[i] > highestValueLeft) {
                    highestValueLeft = blockHeights[i];
                    leftIndex = i;
                }
            }

            for (int i = blockHeights.length - 1; i >= blockHeights.length / 2; i--) {
                if (blockHeights[i] > highestValueRight) {
                    highestValueRight = blockHeights[i];
                    rightIndex = i;
                }
            }
            int tappedWater = 0;
            for (int i = leftIndex; i < rightIndex; i++) {
                tappedWater += highestValueLeft - blockHeights[i];

            }
            return tappedWater;
        }
        // int n = blockHeights.length;
        // int[] l_block_Height = new int[n];
        // int[] r_block_Height = new int[n];
        // l_block_Height[0] = blockHeights[0];
        // for (int i = 1; i < n; i++) {
        // l_block_Height[i] = Math.max(l_block_Height[i - 1], blockHeights[i]);
        // }
        // r_block_Height[n - 1] = blockHeights[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        // r_block_Height[i] = Math.max(r_block_Height[i + 1], blockHeights[i]);
        // }
        // int trappedWater = 0;
        // for (int i = 0; i < n; i++) {
        // int minHeight = Math.min(l_block_Height[i], r_block_Height[i]);
        // trappedWater += Math.max(0, minHeight - blockHeights[i]);
        // }
        // return trappedWater;
    }
}

public class waterConservation {
    public static void main(String[] args) {
        CityBlockConservation c = new CityBlockConservation();
        int[] blockHeights = { 3,  0, 2, 0, 4 };
        int trappedWater = c.calculateTrappedWater(blockHeights);
        System.out.println("Trapped Water: " + trappedWater);
    }
}
