package hospital.dao;

import hospital.models.StaffRole;
import hospital.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    private static final List<User> storage = new ArrayList<>();
    private static int nextId = 1;

    public UserDAO() {
        seedUsers();
    }

    private static void seedUsers() {
        if (!storage.isEmpty()) return;
        storage.add(new User(1, "admin", "admin123", StaffRole.STAFF, null, true));
        storage.add(new User(2, "mercyben", "doctor123", StaffRole.DOCTOR, null, true));
        storage.add(new User(3, "jotieno", "doctor123", StaffRole.DOCTOR, null, true));
        storage.add(new User(4, "akamau", "nurse123", StaffRole.NURSE, null, true));
        storage.add(new User(5, "bmwangi", "pharm123", StaffRole.PHARMACIST, null, true));
        storage.add(new User(6, "dachieng", "lab123", StaffRole.LABORATORY_TECHNICIAN, null, true));
        nextId = 7;
    }

    public boolean add(User user) {
        if (user == null) return false;
        // User has no setId(), so ids are retained when supplied; otherwise assign by
        // reconstructing the object with a generated id.
        if (user.getId() <= 0) {
            User copy = new User(nextId++, user.getUsername(), user.getPasswordHash(),
                    user.getRole(), user.getStaff(), user.isActive());
            storage.add(copy);
        } else {
            storage.add(user);
            nextId = Math.max(nextId, user.getId() + 1);
        }
        return true;
    }
    public List<User> findAll() { return new ArrayList<>(storage); }
    public Optional<User> findById(int id) { return storage.stream().filter(u -> u.getId() == id).findFirst(); }
    public Optional<User> findByUsername(String username) {
        return storage.stream().filter(u -> u.getUsername() != null &&
                username != null && u.getUsername().equalsIgnoreCase(username)).findFirst();
    }
}
