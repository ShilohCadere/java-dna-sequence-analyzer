public class DNASequence {

    private String name;
    private String sequence;

    public DNASequence(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public String getSequence() {
        return sequence;
    }

    public String getReverse() {
        return new StringBuilder(sequence).reverse().toString();
    }

    public String getComplement() {
        String complement = "";

        for (int i = 0; i < sequence.length(); i++) {
            char base = sequence.charAt(i);

            switch (base) {
                case 'A':
                    complement += "T";
                    break;
                case 'T':
                    complement += "A";
                    break;
                case 'C':
                    complement += "G";
                    break;
                case 'G':
                    complement += "C";
                    break;
                default:
                    complement += base;
            }
        }

        return complement;
    }

    public String getReverseComplement() {
        return new StringBuilder(getComplement()).reverse().toString();
    }

    public double getGCContent() {
        int gcCount = 0;

        for (int i = 0; i < sequence.length(); i++) {
            char base = sequence.charAt(i);

            if (base == 'G' || base == 'C') {
                gcCount++;
            }
        }

        return (double) gcCount / sequence.length() * 100;
    }

    public String getRNASequence() {
        return sequence.replace('T', 'U');
    }
}
