package Google.April;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee_Importance {

 //     T(n)= O(n)
//     S(n) = O(n)

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee employee:employees){
            map.put(employee.id,employee);
        }

        ans=dfs(map,map.get(id),0);
        return ans;
    }

    public int dfs(Map<Integer,Employee> map,Employee employee,int curr){
        if (employee==null){
            return curr;
        }

        int sum = employee.importance;
        for (int i :map.get(employee.id).subordinates){
            sum+= dfs(map,map.get(i),curr);
        }

        return sum;
    }

}
