package nextstep.courses.domain.session;

import nextstep.courses.UnAuthorizedException;
import nextstep.users.domain.NsUser;

import static nextstep.courses.ExceptionMessage.UNAUTHORIZED;
import static nextstep.courses.domain.session.EnrollmentStatus.*;

public class Enrollment {
    private Long id;
    private Session session;
    private NsUser enrolledUser;
    private EnrollmentStatus status;

    public Enrollment(Session session, NsUser enrolledUser) {
        this(null, session, enrolledUser, WAITING);
    }

    public Enrollment(Long id, Session session, NsUser enrolledUser, EnrollmentStatus status) {
        this.id = id;
        this.session = session;
        this.enrolledUser = enrolledUser;
        this.status = status;
    }

    public boolean isApproved() {
        return status.isApproved();
    }

    public void approve(NsUser user) {
        updateStatus(user, APPROVED);
    }

    public void reject(NsUser user) {
        updateStatus(user, REJECTED);
    }

    public void wait(NsUser user) {
        updateStatus(user, WAITING);
    }

    private void updateStatus(NsUser user, EnrollmentStatus status) {
        validateSessionCreator(user);
        this.status = status;
    }

    private void validateSessionCreator(NsUser user) {
        if (!session.isSessionCreator(user)) {
            throw new UnAuthorizedException(UNAUTHORIZED.message());
        }
    }

    public Long getId() {
        return id;
    }

    public Session getSession() {
        return session;
    }

    public NsUser getEnrolledUser() {
        return enrolledUser;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }
}
