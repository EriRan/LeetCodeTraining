package fi.eriran.leetcode.problemset.string;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
 * <p>
 * - The first word in the sequence is beginWord.
 * - The last word in the sequence is endWord.
 * - Only one letter is different between each adjacent pair of words in the sequence.
 * - Every word in the sequence is in wordList.
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the
 * shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (validateParameters(beginWord, endWord, wordList)) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        GraphNode startNode = buildGraph(beginWord, wordList);
        if (startNode.getConnections().isEmpty()) {
            return 0;
        }
        return findShortestPath(startNode, endWord);
    }

    private GraphNode buildGraph(String beginWord, List<String> wordList) {
        //Create start node
        GraphNode startNode = new GraphNode(beginWord);
        Map<String, GraphNode> allNodes = new HashMap<>();
        allNodes.put(startNode.getValue(), startNode);
        findConnections(startNode, wordList, allNodes);
        return startNode;
    }

    private void findConnections(GraphNode currentNode,
                                 List<String> wordList,
                                 Map<String, GraphNode> allNodes) {
        for (String word : wordList) {
            if (isOnlyOneCharacterDifferent(currentNode.getValue(), word)) {
                if (!allNodes.containsKey(word)) {
                    GraphNode newNode = new GraphNode(word);
                    allNodes.put(newNode.getValue(), newNode);
                    currentNode.getConnections().add(newNode);
                    findConnections(newNode, wordList, allNodes);
                } else {
                    GraphNode existingNode = allNodes.get(word);
                    currentNode.getConnections().add(existingNode);
                }
            }
        }
    }

    private int findShortestPath(GraphNode startNode, String endWord) {
        Deque<GraphNode> deque = new ArrayDeque<>();
        startNode.setVisited(true);
        deque.add(startNode);
        Map<String, String> pathMap = createPathMap(deque);
        if (!pathMap.containsKey(endWord)) {
            return 0;
        }

        //Let's calculate the path length
        int shortestPathLength = 1;
        String currentNodeValue = pathMap.get(endWord);
        do {
            shortestPathLength++;
            currentNodeValue = pathMap.get(currentNodeValue);
        } while (currentNodeValue != null);
        return shortestPathLength;
    }

    private Map<String, String> createPathMap(Deque<GraphNode> deque) {
        Map<String, String> pathMap = new HashMap<>();
        while (!deque.isEmpty()) {
            GraphNode currentNode = deque.removeFirst();
            for (GraphNode neighbour : currentNode.getConnections()) {
                if (!neighbour.isVisited()) {
                    deque.addLast(neighbour);
                    neighbour.setVisited(true);
                    pathMap.put(neighbour.getValue(), currentNode.getValue());
                }
            }
        }
        return pathMap;
    }

    private boolean isOnlyOneCharacterDifferent(String wordOne, String wordTwo) {
        boolean hasOnlyOneDifferentCharacter = false;
        for (int i = 0; i < wordOne.length(); i++) {
            boolean areCharactersDifferent = wordOne.charAt(i) != wordTwo.charAt(i);
            if (hasOnlyOneDifferentCharacter) {
                if (areCharactersDifferent) {
                    return false;
                }
            } else {
                if (areCharactersDifferent) {
                    hasOnlyOneDifferentCharacter = true;
                }
            }
        }
        return hasOnlyOneDifferentCharacter;
    }

    private boolean validateParameters(String beginWord, String endWord, List<String> wordList) {
        return beginWord == null || endWord == null || wordList == null || wordList.isEmpty();
    }

    class GraphNode {

        private String value;
        private boolean visited;
        private final List<GraphNode> connections;

        public GraphNode() {
            visited = false;
            connections = new ArrayList<>();
        }

        public GraphNode(String value) {
            this.value = value;
            visited = false;
            connections = new ArrayList<>();
        }

        public String getValue() {
            return value;
        }

        public boolean isVisited() {
            return visited;
        }

        public List<GraphNode> getConnections() {
            return connections;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GraphNode graphNode = (GraphNode) o;

            return value != null ? value.equals(graphNode.value) : graphNode.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }
}
