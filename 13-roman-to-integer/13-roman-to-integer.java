class Solution {
    public int romanToInt(String s) {
        // 결과 리턴 시 사용할 변수
        int result = 0;
        // 인자로 받은 문자열을 1개씩 자른다
        String[] chars = s.split("");
        // String[]의 역순으로 순회하면서 숫자가 변하는 조건이 됐을 때 처리를 구현
        for (int i = chars.length - 1; i >= 0; i--) {
            // 숫자가 마이너스되는 경우를 판단할 boolean 변수
            boolean isException = false;
            // 마지막에 도착한 게 아니라면
            if (i != chars.length - 1) {
                // 숫자가 마이너스되는 경우에 해당하는 문자열들에 대한 switch 분기를 만든다
                switch (chars[i]) {
                    case "I":
                        /* I, X, C 다음 글자가 뭐냐에 따라 숫자를 바꿔야 한다 */
                        // IV, IX일 경우
                        if (chars[i + 1].equals("V") || chars[i + 1].equals("X")) {
                            // 숫자가 변하는 조건이 됐으면 boolean 값을 true로 바꾸고 결과를 -n으로 바꾼다
                            // n에는 1, 10, 100이 들어간다. 이는 아래 2개 switch에서도 동일하게 적용된다
                            isException = true;
                            result -= 1;
                        }
                        break;
                    case "X":
                        // XL, XC일 경우
                        if (chars[i + 1].equals("L") || chars[i + 1].equals("C")) {
                            isException = true;
                            result -= 10;
                        }
                        break;
                    case "C":
                        // CD, CM일 경우
                        if (chars[i + 1].equals("D") || chars[i + 1].equals("M")) {
                            isException = true;
                            result -= 100;
                        }
                        break;
                }
            }

            // boolean 변수가 false일 경우
            if (!isException) {
                // 문자에 맞는 숫자를 더한다
                switch (chars[i]) {
                    case "I" -> result = result + 1;
                    case "V" -> result = result + 5;
                    case "X" -> result = result + 10;
                    case "L" -> result = result + 50;
                    case "C" -> result = result + 100;
                    case "D" -> result = result + 500;
                    case "M" -> result = result + 1000;
                }
            }
        }
        return result;
    }
}