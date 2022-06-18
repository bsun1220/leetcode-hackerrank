public class LemonadeStand {
    public boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);

        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                map.put(5, map.get(5) + 1);
            }
            else if (bills[i] == 10){
                if(map.get(5) < 1){
                    return false;
                }
                else{
                    map.put(10, map.get(10) + 1);
                    map.put(5, map.get(5) - 1);
                }
            }
            else if (bills[i] == 20){
                boolean changeOne = map.get(10) >= 1 && map.get(5) >= 1;
                boolean changeTwo = map.get(5) >= 3;
                if(changeOne){
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    map.put(20, map.get(20) + 1);
                }
                else if (changeTwo){
                    map.put(5, map.get(5) - 3);
                    map.put(20, map.get(20) + 1);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
