package RankUp.AktuellStufe4;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SortTreeTest {
    @Test
    public void nullTest() {
        assertEquals(Arrays.asList(), SortTree.treeByLevels(null));
    }

    @Test
    public void basicTest() {
        assertEquals(Arrays.asList(1,2,3,4,5,6),
                SortTree.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2),
                        new Node(new Node(null, null, 5),
                                new Node(null, null, 6), 3), 1)));
    }
}