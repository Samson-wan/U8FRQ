public class ItemGrid
{
    private Item[][] grid;

    /** Constructor */
    public ItemGrid(Item[][] grid)
    {
        this.grid = grid;
    }

    /** Returns true if row is a valid row index and column is a valid
     *  column index and returns false otherwise, as described in part (a)
     */
    public boolean isValid(int row, int column)
    {
        if(row >= 0 && row < grid.length && column >= 0 && column < grid[0].length){
            return true;
        }
        else{
            return false;
        }
    }

    /** Compares the item in row r and column c to the items to its
     *  left and to its right. Returns the name of the item with
     *  the greatest value, as described in part (b).
     *
     *  Precondition: r and c are valid indices
     */
    public String mostValuableNeighbor(int r, int c)
    {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(isValid(r, c-1)){
            left = grid[r][c-1].getValue();
        }
        if(isValid(r,c+1)){
            right = grid[r][c+1].getValue();
        }
        int self = grid[r][c].getValue();
        if(left >= right && left >= self) {
            return grid[r][c -1].getName();
        }
        else if(self >= left && self >= right){
            return grid[r][c].getName();
        }
        else{
            return grid[r][c+1].getName();
        }
    }

    /** Returns the average value of all the items in grid,
     *  as described in part (c).
     */
    public double findAverage()
    {
        int count = 0;
        double total = 0;
        for(Item[] row : grid){
            for(Item item : row){
                count++;
                total += item.getValue();
            }
        }
        return total / count;
    }
}