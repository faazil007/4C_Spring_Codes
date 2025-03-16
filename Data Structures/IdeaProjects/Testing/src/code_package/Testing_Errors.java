package code_package;

public class Testing_Errors
{
    private String error_desc;
    private int error_code;
    private int block_no;
    public Testing_Errors(String err_desc , int err_code , int block_no )
    {
        this.error_desc = err_desc;
        this.error_code = err_code;
        this.block_no = block_no;
    }
    public String getError_desc()
    {
        return error_desc;
    }
    public int getError_code()
    {
        return error_code;
    }
    public int getBlock_No()
    {
        return block_no;
    }

}
