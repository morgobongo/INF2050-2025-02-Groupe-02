package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

public class GroupeCoursImpl {
    List<GroupeCours> groupesCours = new ArrayList<>();

    public void addGroupeCours(GroupeCours e) {groupesCours.add(e);}

    public GroupeCours getGroupeCours(String cours) {
        GroupeCours groupeCours  = new GroupeCours();

        for (GroupeCours g : groupesCours) {
            if (g.getCours().equals(cours)) {
                groupeCours = g;
            }
        }

        return groupeCours;
    }

    public List<GroupeCours> getGroupeCoursSession(String session) {
        List<GroupeCours> groupeCoursSession = new ArrayList<>();

        for (GroupeCours g : groupesCours) {
            if (g.getSession().equals(session)) {
                groupeCoursSession.add(g);
            }
        }
        return groupeCoursSession;
    }

    public List<GroupeCours> getGroupeCoursMaxInscription(Number maxInscription) {
        List<GroupeCours> groupeCoursMaxInscription = new ArrayList<>();
        for (GroupeCours g : groupesCours) {
            if (g.getMaxInscription().equals(maxInscription)) {
                groupeCoursMaxInscription.add(g);
            }
        }
        return groupeCoursMaxInscription;
    }
}
