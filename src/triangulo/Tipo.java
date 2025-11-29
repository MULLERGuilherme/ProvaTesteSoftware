package triangulo;

public enum Tipo {
	 EQUILATERO {
	        @Override
	        public boolean matches(int a, int b, int c) {
	            return a == b && b == c;
	        }
	    },
	    ISOCELES {
	        @Override
	        public boolean matches(int a, int b, int c) {
	            return (a == b || a == c || b == c) && !EQUILATERO.matches(a, b, c);
	        }
	    },
	    ESCALENO {
	        @Override
	        public boolean matches(int a, int b, int c) {
	            return a != b && b != c && a != c;
	        }
	    };

	    public abstract boolean matches(int a, int b, int c);
}
