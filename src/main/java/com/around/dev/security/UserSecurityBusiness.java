package com.around.dev.security;

/**
 * Created by laurent on 19/07/2014.
 */
/*@Service
@Transactional(readOnly = true)
public class UserSecurityBusiness implements UserDetailsService{
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            UserEntity domainUser = userRepository.findByPseudo(s);

            return new User(
                    domainUser.getPseudo(),
                    domainUser.getPassword(),
                    domainUser.getIsactive(),
                    true,//domainUser.isAccountNonExpired(),
                    true,//domainUser.isCredentialsNonExpired(),
                    true,//domainUser.isAccountNonLocked(),
                    domainUser.getRole()
            );

        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}*/
