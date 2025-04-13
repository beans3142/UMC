@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodKind extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 10)
    private String foodType;

    @OneToMany(mappedBy = "likesId", cascade = CascadeType.ALL)
    private List<MemberLikes> memberLikesList = new ArrayList<>();
}