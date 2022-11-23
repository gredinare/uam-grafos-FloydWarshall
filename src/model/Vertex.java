package model;

public class Vertex {
    private String name;

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Vertex(String name) {
        setName(name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Vertex other = (Vertex) obj;
        if(this.getName() == null) {
            return other.getName() == null;
        } else return getName().equals(other.getName());
    }
}