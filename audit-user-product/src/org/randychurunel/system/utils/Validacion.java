package org.randychurunel.system.utils;

public class Validacion {

    public Validacion() {

    }

    public Boolean validateTextEmpty(String text) {
        boolean isEmpty = false;
        if (text.isEmpty() == true || text.isBlank() == true) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public Boolean validateTextLenght(String text, int textMaxPermited) {

        return text.length() <= textMaxPermited;
    }

    public Boolean validatePass(String PassIngrese, String PassConfirmed) {
        return PassIngrese.equals(PassConfirmed);
    }

   public Boolean ValidateEmail(String email) {
    if (email == null) return false;
    
    int numberArroba = 0;
    int arrobaIndex = -1;
    
    // 1. Contar que solo exista un '@' y guardar su posición
    for (int index = 0; index < email.length(); index++) {
        if (email.charAt(index) == '@') {
            numberArroba++;
            arrobaIndex = index;
        }
    }
    
    if (numberArroba != 1) {
        return false;
    }
    
    // 2. Verificar que haya al menos un punto después del '@'
    boolean hasDotAfterArroba = false;
    for (int index = arrobaIndex + 1; index < email.length(); index++) {
        if (email.charAt(index) == '.') {
            hasDotAfterArroba = true;
            break;
        }
    }
    
    return hasDotAfterArroba;
}

 

   
}
