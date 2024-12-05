public class ver {
    public static Boolean Verify(String Input, String type) {
        Boolean result = true;
        int tempInt;
        // General Verification
        if ((!type.equals("Skill")) && Input.contains("#")
        || Input.contains("\\") || Input.contains("|") || Input.contains(";") || Input.contains(":") || Input.contains("\"")
        || Input.contains(",") || Input.contains("<") || Input.contains(">")) {
            result = false;
        }
        // Name/Age Check
        if (type.equals("Name") || type.equals("Age")) {
            if (Input.contains("@") || Input.contains("~") || Input.contains("!") || Input.contains("$") || Input.contains("%")
            || Input.contains("^") || Input.contains("&") || Input.contains("*") || Input.contains("_") || Input.contains("=")
            || Input.contains("+") || Input.contains("-") || Input.contains("}") || Input.contains("{") || Input.contains("'")
            || Input.contains("?") || Input.contains(".") || Input.contains("/") || Input.contains("(") || Input.contains(")")
            || Input.contains(" ") || Input.contains("[") || Input.contains("]")) {
                result = false;
            }
            if (type.equals("Name")) {
                try {
                    tempInt = Integer.parseInt(Input);
                    result = false;
                } catch (Exception e) {}
            } else {
                try {
                    tempInt = Integer.parseInt(Input);
                } catch (Exception e) {
                    result = false;
                }
            }

        // Email Check
        } else if (type.equals("Email")) {
            if (Input.contains("/") || Input.contains("(") || Input.contains(")") || Input.contains(" ") || Input.contains("[")
            || Input.contains("]")) {
                result = false;
            }
            if (!Input.endsWith(".com")) {
                result = false;
            } else {
                Input.replace(".com", "");
            }
            tempInt = 0;
            for (int i = 0; i < Input.length(); i++) {
                if (Input.charAt(i) == '@') {
                    tempInt++;
                }
            }
            if (!(tempInt == 1)) {
                result = false;
            } else {
                Input.replace("@", "");
            }
            if (Input.equals("")) {
                result = false;
            }
        // Phone Number Check
        } else if (type.equals("Number")) {
            if (Input.contains("@") || Input.contains("~") || Input.contains("!") || Input.contains("$") || Input.contains("%")
            || Input.contains("^") || Input.contains("&") || Input.contains("*") || Input.contains("_") || Input.contains("=")
            || Input.contains("+") || Input.contains("}") || Input.contains("{") || Input.contains("'") || Input.contains("?")
            || Input.contains(".") || Input.contains("/") || Input.contains("(") || Input.contains(")") || Input.contains(" ")
            || Input.contains("[") || Input.contains("]")) {
                result = false;
            }
            if (!(Input.length() == 12)) {
                result = false;
            }
            if ((Input.length() > 8) && (!((Input.charAt(4) == '-') && (Input.charAt(8) == '-')))) {
                result = false;
            }
            try {
                Input.replaceAll("-", "");
                tempInt = Integer.parseInt(Input);
            } catch (Exception e) {
                result = false;
            }
        // Skill Check
        } else if (type.equals("Skill")) {
            if (Input.contains("@") || Input.contains("~") || Input.contains("!") || Input.contains("$") || Input.contains("%")
            || Input.contains("^") || Input.contains("*") || Input.contains("_") || Input.contains("=") || Input.contains("+")
            || Input.contains("'") || Input.contains("?") || Input.contains("/")) {
                result = false;
            }

        // Date Check
        } else if (type.equals("Date")) {
            if (Input.contains("@") || Input.contains("~") || Input.contains("!") || Input.contains("$") || Input.contains("%")
            || Input.contains("^") || Input.contains("&") || Input.contains("*") || Input.contains("_") || Input.contains("=")
            || Input.contains("+") || Input.contains("-") || Input.contains("}") || Input.contains("{") || Input.contains("'")
            || Input.contains("?") || Input.contains(".") || Input.contains("(") || Input.contains(")") || Input.contains(" ")
            || Input.contains("[") || Input.contains("]")) {
                result = false;
            }
            tempInt = 0;
            for (int i = 0; i < Input.length(); i++) {
                if (Input.charAt(i) == '/') {
                    tempInt++;
                }
            }
            Input.replaceAll("/", "");
            if (tempInt > 2) {
                result = false;
            }
            try {
                tempInt = Integer.parseInt(Input);
                if (!(tempInt == 8)) {
                    result = false;
                }
            } catch (Exception e) {
                result = false;
            }
        } else {
            System.out.println("CRITICAL ERROR! VERIFICATION TYPE NOT RECOGNIZED");
        }
        return result;
    }
}
