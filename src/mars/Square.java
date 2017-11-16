package mars;

public class Square {
  private int row;
  private int column;
  public Square(int row, int column) {
    this.row = row;
    this.column = column;
  }
  public int getRow() {
    return row;
  }
  public int getColumn() {
    return column;
  }
  
  @Override
  public boolean equals(Object that) {
    if (that instanceof Square) {
      return (this.row == ((Square)that).row && this.column == ((Square)that).column);
    }
    else return false;
  }
  public int hashCode() {
    return 31*(31 + this.row) + this.column;
  }
}
