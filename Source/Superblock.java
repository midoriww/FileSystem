/**
 *  Created by Ko Fukushima and Jesse Luo on 7/9/2016.
 *
 *  This class is used to describe the number of disk blocks
 *  , the number of inodes, and the block number of the
 *  head block of the free list.
 */
public class Superblock
{
    public int totalBlocks; // the number of disk blocks
    public int totalInodes; // the number of inodes
    public int freeList;    // the block number of the free List's head

    /**
     * Class constructor that initializes the fields that are tatalBlocks,
     * totalInodes, and freeList
     *
     * @param diskSize the disk size
     */
    public Superblock( int diskSize)
    {
    }
}

//------ added by midori 7/23/16 -------//
Class SuperBlock {
    Public int totalBlocks;		// the number of disk blocks
    Public int totalInodes;		// the number of inodes
    Public int freeList;		// the block number of the free list’s head

    Public SuperBlock( int diskSize ) {
    // read superblock from disk
        Byte[] superBlock = new byte[Disk.blockSize];
        SysLib.rawread( 0, superBlck );
        totalBlocks = SysLib.bytes2int( superBlock, 0 );
        totalInodes = SysLib.bytes2int( superBlock, 4 );
        freeList = SysLib.bytes2int( superBlock, 8 );

        If ( totalBlocks == diskSize && totalInodes > 0 && freeList >= 2 )
	        return;	// disk contents are valid
        Else {
	    // need to format disk
	        totalBlocks = diskSize;
	        format( defaultInodeBlocks );
        }
    }
}
