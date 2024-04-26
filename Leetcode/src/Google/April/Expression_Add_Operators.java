package Google.April;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    public ArrayList<String> answer;
    public String digits;
    public long target;

    public void solve(int index, long prev, long curr, long value, ArrayList<String> ans) {

        if (index == digits.length()) {
            if (target == value && curr == 0) {
                StringBuilder sb = new StringBuilder();
                ans.subList(1, ans.size()).forEach(v -> sb.append(v));
                answer.add(sb.toString());
            }

            return;
        }

        curr = curr * 10 + Character.getNumericValue(digits.charAt(index));
        String curr_value = Long.toString(curr);

        if (curr > 0) {
            solve(index + 1, prev, curr, value, ans);
        }

        ans.add("+");
        ans.add(curr_value);
        solve(index + 1, curr, 0, value + curr, ans);
        ans.remove(ans.size() - 1);
        ans.remove(ans.size() - 1);

        if (ans.size() >= 1) {
            ans.add("-");
            ans.add(curr_value);
            solve(index + 1, -curr, 0, value - curr, ans);
            ans.remove(ans.size() - 1);
            ans.remove(ans.size() - 1);


            ans.add("*");
            ans.add(curr_value);
            solve(index + 1, curr * prev, 0, value - prev + prev * curr, ans);
            ans.remove(ans.size() - 1);
            ans.remove(ans.size() - 1);
        }

    }

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<String>();
        }
        answer = new ArrayList<>();
        digits = num;
        this.target = target;
        solve(0, 0, 0, 0, new ArrayList<>());
        return answer;
    }

}