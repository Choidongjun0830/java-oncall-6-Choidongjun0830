package oncall.utils;

import java.util.regex.Pattern;

public class Regex {
    //XYZ 중 하나를 한 글자만 입력받는 정규식
    public static final Pattern ONE_CHAR_REGEX = Pattern.compile("[XYZ]");

    // 한글자 이상의 한글. "[한글]" 형식의 문자열을 입력받는 정규식
    public static final Pattern KOREAN_WITH_BRACKET_REGEX = Pattern.compile("\\[[가-힣]+\\]");

    // "[한글-숫자]" 형식의 문자열을 입력받는 정규식
    public static final Pattern KOREAN_WITH_BRACKET_AND_NUMERIC_REGEX = Pattern.compile("\\[[가-힣]+-[0-9]+\\]");
    // 한글 영어
    public static final Pattern KOREAN_WITH_ENGLISH = Pattern.compile("[가-힣a-zA-Z]+");
    // 한글 영어 공백
    public static final Pattern KOREAN_WITH_ENGLISH_AND_SPACE = Pattern.compile("[가-힣a-zA-Z ]");

    //참고용 정규식들
    public static final Pattern NUMERIC_REGEX = Pattern.compile("[0-9]+"); //한글자 이상의 숫자
    public static final Pattern KOREAN_REGEX = Pattern.compile("[가-힣]+"); // 한글자 이상의 한글
    public static final Pattern ENGLISH_REGEX = Pattern.compile("[a-zA-Z]+"); // 한글자 이상의 대소문자 영어
    public static final Pattern ALPHANUMERIC_REGEX = Pattern.compile("[a-zA-Z0-9]+"); //영어와 숫자 조합 허용
    public static final Pattern ALPHANUMERIC_WITH_SPACE_REGEX = Pattern.compile("[a-zA-Z0-9 ]+"); //영어 숫자 조합과 공백 허용
}