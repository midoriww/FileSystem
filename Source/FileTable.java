/**
 *  Created by Ko Fukushima and Jesse Luo on 7/9/2016.
 *
 *  This class manages file entry table by allocating for,
 *  freeing, emptying the entry in the table
 *
 */

import java.util.Vector;

public class FileTable
{
    private Vector table;
    private Directory dir;

    /**
     * Class constructor that initializes the fields of table
     * and dir.
     *
     * @param directory the directory
     */
    public FileTable(Directory directory)
    {
        table = new Vector();
        dir = directory;
    }

    /**
     * This method allocates a new file table entry for this file name
     * and it also allocate/retrive and register the corresoponding inode
     * using dir increment this inode's count immediately write back this
     * inode this inode to the disk
     *
     * @param filename the file name
     * @param mode the mode such as "r", "w", "w+", or "a"
     * @return a reference to the file table entry
     * 
     * edited 7/23/16 by Midori
     */
    public synchronized FileTableEntry falloc(String filename, String mode)
    {
        seekPt =0
        iNode = i;
        iNumber = inumber;
        count = 1; 
 
        //modes available
        mode = mode.toLowerCase();
        if (mode.compareTo("r") == 0)
            return READONLY;
        if (mode.compareTo("w") == 0)
            return WRITEONLY;
        if (mode.compareTo("w+") == 0)
            return READWRITE;
        if (mode.compareTo("a") == 0)
            return APPEND;
        return -1;
 
 
        iNode.count++; increment
        if (mode == APPEND) // if mode is append
            seekPtr = iNode.length; // seekPtr points to the end of file
    }

    /**
     * This method receive a file table entry reference
     * and save the corresponding inode to the disk
     * and free this file table entry
     *
     * @param e the file table entry
     * @return True if this file entry found in the table,
     * false otherwise
     * edited on 7/23/16 by Midori
     */
    public synchronized boolean ffree(FileTableEntry e)
    {
        boolean value = table.remove(e)
 	    if (value ==  true) {                                                               
            e.inode.flag=0;                                                                                                          		                	  if(e.inode.count != 0)
	        E.inode.count--;
            SysLib.cerr(" " + e.inode.count);
	        e.inode.toDisk(e.iNumber); //save to disk
                                                                           
            //write to direct
             e = null;
            Return true;
        } 
        else {
            System.err.println("freeing nonexistent FTE");
            Return false;
        }

    /**
     * This method clear all file table entry in the table
     * and it should be called before starting a format
     *
     * @return True if table is empty and false otherwise
     */
    public synchronized boolean fempty( )
    {
        return table.isEmpty();
    }
}
