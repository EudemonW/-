package com.jinhang.DTO;

import com.jinhang.model.Dept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptTreeNodeDTO {
    private Dept node;
    private List<DeptTreeNodeDTO> childs;


    public static List<DeptTreeNodeDTO> listToTree(List<DeptTreeNodeDTO> list )
    {
        List<DeptTreeNodeDTO> treeList = new ArrayList<>();

        for ( DeptTreeNodeDTO dept : list )
        {
            if ( "0".equals( dept.getNode().getParent_dept_id() ) )
                treeList.add(findChildren( dept, list ) );
        }
        return treeList;
    }

    private static DeptTreeNodeDTO findChildren(DeptTreeNodeDTO tree, List<DeptTreeNodeDTO> list) {

        for (DeptTreeNodeDTO node : list)
        {
            if ( node.getNode().getParent_dept_id() .equals( tree.getNode().getId() ) )
            {
                if ( tree.getChilds() == null)
                {
                    tree.setChilds(new ArrayList<DeptTreeNodeDTO>());
                }
                tree.getChilds().add(findChildren(node, list));
            }
        }
        return tree;
    }

    public DeptTreeNodeDTO buildDeptTree(List<Dept> list )
    {
        List<DeptTreeNodeDTO> tree = new ArrayList<>();
        for( Dept dept : list )
        {
            DeptTreeNodeDTO node = new DeptTreeNodeDTO();
            node.setNode( dept );
            tree.add( node );
        }
        return listToTree( tree ).get(0);
    }
}
