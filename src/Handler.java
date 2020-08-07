public class Handler {

    public static void main(String...args) {
        // Let's create a HashMap:
        HashMap<Integer, Long> hashMap = new HashMap<>(5);
        // Then, populate it:
        hashMap.put(80, 22L);
        hashMap.put(16, 11L);
        hashMap.put(59, 43L);
        hashMap.put(73, 77L);
        hashMap.put(12, 122L);
        // Let's see what are the size and the contents:
        System.out.println(hashMap.toString());
        // Let's find ourselves some value:
        System.out.println("Found: " + hashMap.get(11));
        // Oops, nonexistent :) Adding it!
        hashMap.put(11, 101L);
        System.out.println(hashMap.toString());
        // Finding again:
        System.out.println("Found: " + hashMap.get(11));
        // Here it is.
    }

}
