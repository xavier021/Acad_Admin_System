package acadadminsystem_phase3;

import java.util.ArrayList;


public class AcadAdminUtility 
{
    public static < E extends Comparable > void sortArrayList (ArrayList<E> list)
    {
       int lastPos;
        int index;
        E temp;
        
        if(list.size()>1)
        {
            for( lastPos = list.size() - 1; lastPos > 0; lastPos-- )
            {
                for( index = 0; index <= lastPos - 1; index++ )
                {
                    if ( list.get(index).compareTo(list.get(index+1)) > 0 )
                    {
                        temp = list.get(index);
                        list.set(index,list.get(index+1));
                        list.set(index+1, temp);
                    }
                }
            }
        }
    }
}
