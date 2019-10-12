package ast;

import general.Visitor;

public class Arc extends AST {

    public String fromNode;
    public String toNode;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Arc)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Arc c = (Arc) o;

        // Compare the data members and return accordingly
        return fromNode.equals(c.fromNode) && toNode.equals(c.toNode);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fromNode.hashCode();
        result = 31 * result + toNode.hashCode();
        return result;
    }
}
