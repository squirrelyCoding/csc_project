public class ver {
    public static Boolean Verify(String Input, String type) {
        Boolean result = true;
        int tempInt;
        // General Verification
        if (!(type.equals("Email")) && (Input.contains("!") || Input.contains("@") || Input.contains("#") || Input.contains("$") || Input.contains("%")
        || Input.contains("^") || Input.contains("&") || Input.contains("*") || Input.contains("(") || Input.contains(")")
        || Input.contains("_") || Input.contains("=") || Input.contains("+") || Input.contains("`") || Input.contains("~")
        || Input.contains("[") || Input.contains("{") || Input.contains("]") || Input.contains("}") || Input.contains("\\")
        || Input.contains(";") || Input.contains(":") || Input.contains("'") || Input.contains("|") || Input.contains("\"")
        || Input.contains(",") || Input.contains("<") || Input.contains(".") || Input.contains(">") || Input.contains("?")
        || Input.contains(" "))) {
            result = false; // One or more special characters in Input (unless it's an Email)
        }
        // Name/Age Check
        if (type.equals("Name") || type.equals("Age")) {
            if (Input.contains("-") || Input.contains("/")) {
                result = false; // Name/Age includes "-" and/or "/"
            }
            if (type.equals("Name")) {
                if (!numCheck(Input)) {
                    result = false; // Number's included in Name
                }
            } else {
                if (!charCheck(Input)) {
                    result = false; // Character's included in Age
                }
            }
        // Email Check
        } else if (type.equals("Email")) {
            if (Input.contains("#") || Input.contains("(") || Input.contains(")") || Input.contains("`")
            || Input.contains("[") || Input.contains("]") || Input.contains("\\") || Input.contains("|") || Input.contains(";")
            || Input.contains(":") || Input.contains("\"") || Input.contains(",") || Input.contains("<") || Input.contains(">")
            || Input.contains("/") || Input.contains(" ")) {
                result = false; // Unrecognized Special Character's
            }
            if (!Input.endsWith(".com")) {
                result = false; // Email doesn't end with ".com"
            }
            tempInt = 0;
            for (int i = 0; i < Input.length(); i++) {
                if (Input.charAt(i) == '@') {
                    tempInt++;
                }
            }
            if ((tempInt != 1)) {
                result = false; // More than 1 "@"
            }
            if (Input.endsWith(".com")) {
                Input.replace(".com", "");
                Input.replace("@", "");
                if (Input.equals("")) {
                    result = false; // No email provided
                }
            }
        // Phone Number Check
        } else if (type.equals("Number")) {
            if (Input.contains("/")) {
                result = false; // Phone Number Includes "/"
            }
            if (Input.length() != 12) {
                result = false; // Phone number not of 12 characters in size
            }
            tempInt = 0;
            for (int i = 0; i <Input.length(); i++) {
                if (Input.charAt(i) == '-') {
                    tempInt++;
                }
            }
            if (tempInt != 2) {
                result = false; // Not exactly 2 "-"'s
            }
            if ((Input.length() > 8) && (!((Input.charAt(3) == '-') && (Input.charAt(7) == '-')))) {
                result = false; // "-"'s not in valid locations
            }
            Input.replaceAll("-", "");
            if (!charCheck(Input)) {
                result = false; // Characters included in Phone Number
            }
        // Date Check
        } else if (type.equals("Date")) {
            if (Input.contains("-")) {
                result = false; // Date Includes "-"
            }
            if (Input.length() != 10) {
                result = false; // Date not of 10 characters in size
            }
            tempInt = 0;
            for (int i = 0; i < Input.length(); i++) {
                if (Input.charAt(i) == '/') {
                    tempInt++;
                }
            }
            if (tempInt != 2) {
                result = false; // Not exactly 2 "/"'s
            }
            if ((Input.length() > 6) && (!((Input.charAt(2) == '/') && (Input.charAt(5) == '/')))) {
                result = false; // "/"'s not in valid locations
            }
            Input.replaceAll("/", "");
            if (!charCheck(Input)) {
                result = false; // Characters included in Date
            }
        } else {
            System.out.println("CRITICAL ERROR! VERIFICATION TYPE NOT RECOGNIZED");
        }
        return result;
    }

    
    public static Boolean numCheck(String Input) {
        boolean result = true;
        if (Input.contains("1") || Input.contains("2") || Input.contains("3") || Input.contains("4") || Input.contains("5")
        || Input.contains("6") || Input.contains("7") || Input.contains("8") || Input.contains("9") || Input.contains("10")) {
            result = false; // Num's in String
        }
        return result;
    }
    public static Boolean charCheck(String temp) {
        boolean result = true;
        String Input = "";
        int i;
        for (i = 0; i < temp.length(); i++) {
            Input = Input + Character.toLowerCase(temp.charAt(i));
        }
        if (Input.contains("a") || Input.contains("b") || Input.contains("c") || Input.contains("d") || Input.contains("e")
        || Input.contains("f") || Input.contains("g") || Input.contains("h") || Input.contains("i") || Input.contains("j")
        || Input.contains("k") || Input.contains("l") || Input.contains("m") || Input.contains("n") || Input.contains("o")
        || Input.contains("p") || Input.contains("q") || Input.contains("r") || Input.contains("s") || Input.contains("t")
        || Input.contains("u") || Input.contains("v") || Input.contains("w") || Input.contains("x") || Input.contains("y")
        || Input.contains("z")) {
            result = false; // Char's in String
        }
        return result;
    }
}
