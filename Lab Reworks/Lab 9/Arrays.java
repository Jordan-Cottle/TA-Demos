public class Arrays{
    public static void main(String[] args) {
        final int size = 10;
        int [] numbers = randomArray(size, -10, 10);
        printArray(numbers);
        printArray(numbers, 0, numbers.length-1, 1);
        printReversed(numbers);
        printAlternate(numbers);

        int[] offset = pop(numbers, 5);
        printArray(offset);

        offset = pop(offset, 3);
        printAlternate(offset);

        int[] resized = resize(numbers, 2);
        printArray(resized);

        // Bonus!
        resized = resize(numbers, 1.0/2.0);
        printArray(resized);
    }

    private static int[] randomArray(int size , int min, int max){
        int delta = max-min+1; // add one to make max inclusive

        int offset = min;
        if(min < 0){
            offset -= 1;

            if(max > 0){
                delta += 1;
            }
        }

        int [] numbers = new int [size];
        for(int i = 0 ; i < numbers.length; i++){
            numbers[i] = (int)(Math.random()*delta + offset);

            if(numbers[i] < min || numbers[i] > max){
                throw new RuntimeException(String.format("Error! %d is outsize of the range!", numbers[i]));
            } 
        }

        return numbers;
    }

    private static void printArray(int[] numbers){
        System.out.print("[ ");
        for(int num: numbers){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    private static void printArray(int[] numbers, int start, int end, int step){
        System.out.print("[ ");
        for(int i = start; end > start? i <= end: i >= end; i += step){
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    private static void printReversed(int[] numbers){
        printArray(numbers, numbers.length-1, 0, -1);
    }

    private static void printAlternate(int[] numbers){
        printArray(numbers, 0, numbers.length-1, 2);
    }

    private static int[] copy(int[] numbers){
        int [] copy = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            copy[i] = numbers[i];
        }

        return copy;
    }

    private static int[] pop(int[] numbers, int index){
        int[] copy = copy(numbers);

        for(int i = index; i < copy.length-1; i++){
            copy[i] = copy[i+1];
        }

        copy[numbers.length-1] = 0;

        return copy;
    }

    private static int[] resize(int[] numbers, double multiple){
        if (multiple == 1.0){
            return copy(numbers);
        }

        int newSize = (int) (numbers.length * multiple);

        int[] result = new int[newSize];

        for(int i = 0; multiple > 1 ? i < numbers.length: i < newSize; i++){
            result[i] = numbers[i];
        }

        return result;
    }
}