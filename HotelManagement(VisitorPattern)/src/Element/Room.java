package Element;

import Visitor.Visitor;

public interface Room {
    public void accept(Visitor visitor);
}
