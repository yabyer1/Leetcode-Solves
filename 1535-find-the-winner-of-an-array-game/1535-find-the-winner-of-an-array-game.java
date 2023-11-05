class Solution {
    public int getWinner(int[] arr, int k) {
        if(k > arr.length){
            Arrays.sort(arr);
            return arr[arr.length - 1];
        }
        int finished = 0;
        boolean x = false;
        Queue<Integer> numLine = new LinkedList<>();
        int selected = arr[0];
        for(int j = 1; j < arr.length; j++){
            numLine.add(arr[j]);
        }
        while(finished != 1){
            int strk = (x == true) ? 1 : 0;
            while(strk < k && selected > numLine.peek()){
                    numLine.add(numLine.remove());
                    strk++;
            }
            if(strk == k){
                return selected;
            }
            if(selected < numLine.peek()){
                numLine.add(selected);
                selected = numLine.remove();
                x = true;
            }

        }
        return -1;
    }
}