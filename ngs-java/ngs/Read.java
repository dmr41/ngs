/*===========================================================================
*
*                            PUBLIC DOMAIN NOTICE
*               National Center for Biotechnology Information
*
*  This software/database is a "United States Government Work" under the
*  terms of the United States Copyright Act.  It was written as part of
*  the author's official duties as a United States Government employee and
*  thus cannot be copyrighted.  This software/database is freely available
*  to the public for use. The National Library of Medicine and the U.S.
*  Government have not placed any restriction on its use or reproduction.
*
*  Although all reasonable efforts have been taken to ensure the accuracy
*  and reliability of the software and data, the NLM and the U.S.
*  Government do not and cannot warrant the performance or results that
*  may be obtained by using this software or data. The NLM and the U.S.
*  Government disclaim all warranties, express or implied, including
*  warranties of performance, merchantability or fitness for any particular
*  purpose.
*
*  Please cite the author in any work or product based on this material.
*
* ===========================================================================
*
*/

package ngs;


/*==========================================================================
 * Read
 *  represents an NGS machine read
 *  having some number of biological Fragments
 */
public interface Read
    extends FragmentIterator
{

    /**
     * getReadId
     */
    String getReadId ()
        throws ErrorMsg;


    /*----------------------------------------------------------------------
     * Fragment
     */

    /**
     * getNumFragments
     * @return the number of biological Fragments contained in the read
     */
    int getNumFragments ()
        throws ErrorMsg;


    /*----------------------------------------------------------------------
     * read details
     */

    /**
     * ReadCategory
     */
    static int fullyAligned     = 1;
    static int partiallyAligned = 2;
    static int aligned          = fullyAligned | partiallyAligned;
    static int unaligned        = 4;
    static int all              = aligned | unaligned;

    /**
     * getReadCategory
     */
    int getReadCategory ()
        throws ErrorMsg;

    /**
     * getReadGroup
     */
    String getReadGroup ()
        throws ErrorMsg;

    /**
     * getReadName
     */
    String getReadName ()
        throws ErrorMsg;


    /** 
     * getReadBases
     * @return sequence bases
     */
    String getReadBases ()
        throws ErrorMsg;

    /** 
     * getReadBases
     * @param offset is zero-based and non-negative
     * @return sequence bases
     */
    String getReadBases ( long offset )
        throws ErrorMsg, IndexOutOfBoundsException;

    /** 
     * getReadBases
     * @param offset is zero-based and non-negative
     * @param length must be &ge; 0
     * @return sequence bases
     */
    String getReadBases ( long offset, long length )
        throws ErrorMsg, IndexOutOfBoundsException;


    /**
     * getReadQualities
     * @return phred quality values using ASCII offset of 33
     */
    String getReadQualities ()
        throws ErrorMsg;

    /**
     * getReadQualities
     * @param offset is zero-based and non-negative
     * @return phred quality values using ASCII offset of 33
     */
    String getReadQualities ( long offset )
        throws ErrorMsg, IndexOutOfBoundsException;

    /**
     * getReadQualities
     * @param offset is zero-based and non-negative
     * @param length must be &ge; 0
     * @return phred quality values using ASCII offset of 33
     */
    String getReadQualities ( long offset, long length )
        throws ErrorMsg, IndexOutOfBoundsException;
}
