package hackerrank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static class PositiveReview {
        Integer userId;
        Integer businessId;

        public PositiveReview(Integer userId, Integer businessId) {
            this.userId = userId;
            this.businessId = businessId;
        }

        public Integer getUserId() {
            return this.userId;
        }
        public Integer getBusinessId() {
            return this.businessId;
        }
    }

    public static Integer findMostSimilarBusiness(Integer businessOfInterestId,
            List<PositiveReview> positiveReviews) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (PositiveReview pr: positiveReviews) {
            Set<Integer> users = map.getOrDefault(pr.getBusinessId(), new HashSet<>());
            users.add(pr.getUserId());
            map.put(pr.getBusinessId(), users);
        }

        Set<Integer> usersOfInterest = map.get(businessOfInterestId);

        double maxscore = -1.0;
        int mostSimilar = -1;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Integer id = entry.getKey();
            if (!id.equals(businessOfInterestId)) {
                Set<Integer> users = entry.getValue();
                Set<Integer> union = Stream.concat(usersOfInterest.stream(), users.stream()).collect(Collectors.toSet());
                Set<Integer> intersect = usersOfInterest.stream().filter(users::contains).collect(Collectors.toSet());
                double score = 1.0 * intersect.size() / union.size();
                if (score > maxscore) {
                    maxscore = score;
                    mostSimilar = id;
                }
            }
        }
        return mostSimilar;
    }

    public static void main(String[] args) {

        System.out.println(
            findMostSimilarBusiness(10, Arrays.asList(
                    new PositiveReview(1, 10),
                    new PositiveReview(2, 10),
                    new PositiveReview(1, 11),
                    new PositiveReview(2, 11),
                    new PositiveReview(1, 12),
                    new PositiveReview(2, 12),
                    new PositiveReview(3, 12)
            ))
        );
    }

}
