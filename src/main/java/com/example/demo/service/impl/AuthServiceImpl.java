@Service
public class AuthServiceImpl {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(
            AppUserRepository appUserRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider) {

        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    public void register(RegisterRequest request) {}

    public String login(LoginRequest request) {
        return "token";
    }
}
