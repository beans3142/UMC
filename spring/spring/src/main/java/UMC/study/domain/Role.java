@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<MemberRole> memberRoleList = new ArrayList<>();
}