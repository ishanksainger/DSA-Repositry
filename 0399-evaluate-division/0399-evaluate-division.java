class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map=new HashMap<>();
        int n=equations.size();
        for(int i=0;i<n;i++){
            String str1=equations.get(i).get(0);
            String str2=equations.get(i).get(1);
            double val=values[i];

            map.putIfAbsent(str1,new HashMap<>());
            map.get(str1).put(str2,val);

            map.putIfAbsent(str2,new HashMap<>());
            map.get(str2).put(str1,1.0/val);
        }
        int m=queries.size();
        double[] result=new double[m];    
        for(int i=0;i<m;i++){
            String str1=queries.get(i).get(0);
            String str2=queries.get(i).get(1);

            if(!map.containsKey(str1) || !map.containsKey(str2)){
                result[i]=-1;
            }
            else{
                result[i]=dfs(map,str1,str2,new HashSet<>());
            }
        }
        return result;
    }
        public double dfs(Map<String,Map<String,Double>> map, String src, String dest, HashSet<String> visited){
            if(src.equals(dest)){
                return 1.0;
            }
            visited.add(src);
            for(Map.Entry<String, Double> mp: map.get(src).entrySet()){
                String newSrc=mp.getKey();
                double val=mp.getValue();
                if(!visited.contains(newSrc)){
                    double result=dfs(map,newSrc,dest,visited);
                    if(result!=-1){
                        return val*result;
                    }
                }
            }
            return -1;
        }
    }
