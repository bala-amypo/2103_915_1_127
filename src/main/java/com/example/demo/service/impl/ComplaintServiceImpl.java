@Override
public Complaint submitComplaint(ComplaintRequest request, User user) {

    Complaint complaint = new Complaint();
    complaint.setTitle(request.getTitle());
    complaint.setDescription(request.getDescription());
    complaint.setCategory(request.getCategory());
    complaint.setChannel(request.getChannel());

    complaint.setSeverity(
            Complaint.Severity.valueOf(request.getSeverity().toUpperCase())
    );

    complaint.setUrgency(
            Complaint.Urgency.valueOf(request.getUrgency().toUpperCase())
    );

    // ✅ correct method name
    priorityRuleService.calculatePriorityScore(complaint);

    return complaintRepository.save(complaint);
}
